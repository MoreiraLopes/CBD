from os import write
import csv
from neo4j import GraphDatabase
from time import sleep


# pip3 install neo4j


class lab44c:
    
    def __init__(self, uri, user, password):
        self.driver = GraphDatabase.driver(uri, auth=(user, password))
        
        self.questions = ["1. List all different teams",
                              "2. List all the players that played for the team 'LAL'?",
                              "3. How many players were active in the season '1997-98'?",
                              "4. Which players had an average of more than 16 points and played for the team HOU.",
                              "5. List the 20 player with better stats(more points) in the season '1996-97'.",
                              "6. List all players that are taller than 210cm and played for the team 'POR'.",
                              "7. List all players, and their ages, who played for the team 'GSW' in the season '1996-97'.",
                              "8. List all players that are younger than 22 years old in the season 1996-97.",
                              "9. List all the seasons.",
                              "10. List the 10 tallest players."]
        
        self.answers = ['''MATCH (team:Team)
                        RETURN DISTINCT team.abbreviation AS Team''',

                        '''MATCH (p:Player)-[:PLAYS_FOR]->(t:Team {abbreviation: 'LAL'})  
                        RETURN DISTINCT p.name AS Player''',

                        '''MATCH (p:Player)-[:PLAYS_IN]->(s:Season {season_year: '1997-98'})
                        RETURN count(p) AS NumberOfPlayers''',

                        '''MATCH (team:Team {abbreviation: 'HOU'})<-[:PLAYS_FOR]-(player:Player)-[:HAS_STAT]->(stat:Stat) 
                        WITH player, AVG(stat.points) AS avgPoints 
                        WHERE avgPoints > 16 
                        RETURN player.name AS Player, avgPoints AS AveragePoints''',

                        '''MATCH (stat:Stat)<-[:HAS_STAT]-(player:Player)-[:PLAYS_IN]->(season:Season {season_year: '1997-98'}) 
                        RETURN player.name AS PlayerName, stat.points AS Points, stat.rebounds AS Rebounds, stat.assists AS Assists 
                        ORDER BY stat.points DESC 
                        LIMIT 20''',

                        '''MATCH (player:Player)-[:PLAYS_FOR]->(team:Team {abbreviation: 'POR'}) 
                        WHERE player.height > 210 
                        RETURN player.name AS PlayerName, player.height AS Height, team.abbreviation AS Team''',

                        '''MATCH (season:Season {season_year: '1996-97'})<-[:PLAYS_IN]-(player:Player)-[:PLAYS_FOR]->(team:Team {abbreviation: 'GSW'}) 
                        RETURN player.name AS PlayerName, player.age AS Age''', 

                        '''MATCH (player:Player)-[:PLAYS_IN]->(:Season {season_year: '1996-97'}) 
                        WHERE player.age < 22  
                        RETURN DISTINCT player.name AS PlayerName, player.age AS Age 
                        ORDER BY Age''',

                        '''MATCH (season:Season) 
                        RETURN season.season_year AS SeasonYear''',

                        '''MATCH (p:Player) 
                        RETURN DISTINCT p.name AS PlayerName, p.height AS Height 
                        ORDER BY p.height DESC LIMIT 10''']

                                        
    
    def create(self):
        self.driver.session().run(
            """
            LOAD CSV WITH HEADERS FROM 'file:///all_seasons.csv' AS row  
            WITH row.player_name AS player_name, row.team_abbreviation AS team_abr,  
                toInteger(row.age) AS age, toFloat(row.player_height) AS height,  
                toFloat(row.pts) AS pts, toFloat(row.reb) AS reb,  
                toFloat(row.ast) AS ast, row.season AS season_year  
            MERGE (player:Player {name: player_name, age: age, height: height })  
            MERGE (team:Team {abbreviation: team_abr})  
            MERGE (season:Season {season_year: season_year})  
            MERGE (stat:Stat {points: pts, rebounds: reb, assists: ast})  
            MERGE (player)-[:PLAYS_FOR]->(team)  
            MERGE (player)-[:PLAYS_IN]->(season)  
            MERGE (player)-[:HAS_STAT]->(stat)
            """
        )
           


    def queriesAndSave(self):
        f = open("CBD_L44c_output.txt", "a")
        for i, query in enumerate(self.answers):
            result = self.driver.session().run(query)
            f.write("\n\n" + self.questions[i] + "\n")
            f.write(query + "\n\n---")
            print("Executing query", i+1)
            

            results=[r for r in result.data()]
            print(results)

            for k in results[0].keys():
                f.write(f" {k}                  ")
            
            f.write("---")
            
            for r in results:
                f.write("\n")
                for v in r.values():
                    f.write(f" {str(v)}             ")
                    
            if(len(results)>10):
                f.write("\n...")

            f.write("\n")
        f.close()
            

    def close(self):
        self.driver.close()


if __name__ == "__main__":
    try:
        bd = lab44c("bolt://localhost:7687", "neo4j", "password")
        print("Connected to database!")
        bd.create()
        sleep(4)
        bd.queriesAndSave()
        print("All queries were sucessfully executed. Check the CBD_L44c_output.txt for the results!")
        bd.close()
    except Exception as e:
        print("There was an error!", e)
        print("Maybe check if you have neo4j installed for Python, if not run 'pip3 install neo4j' in any terminal!")