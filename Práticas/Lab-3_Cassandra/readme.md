# CBD Lab 3

Sample workspace for completing the CBD Lab 3.

This workspace provides a docker-compose file to an instance of Cassandra, and it's companions, in a dockerized enviromnment.

The [resources folder](resources) is automatically mounted to `/resources` in the container.
It contains some assets required to complete the Lab.


`docker-compose up -d`

Open `cqlsh` on the container:
`docker-compose exec -it cassandra cqlsh`


Create json files ex:
`docker compose exec -it cassandra cqlsh -e 'SELECT JSON * FROM cbd_107572_ex2.videos' > videos_data.json`


## Additional Notes

* Make sure you have previously installed [Docker Desktop](https://docs.docker.com/desktop/), or at least Docker Engine.
* [Official Docker Compose tutorial](https://docs.docker.com/compose/gettingstarted/)
