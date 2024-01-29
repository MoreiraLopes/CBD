//numeros sem digitos repetidos

function findNumbersWithUniqueDigits() {
    return db.phones.find().limit(50000).toArray().filter(function(item) {
        const idString = item._id.toString().slice(3);
        return new Set(idString.split('')).size === idString.length;
    }).map(item => item._id);
}


