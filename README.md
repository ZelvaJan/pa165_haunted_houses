# pa165_haunted_houses

Project Haunted Houses for PA165

for more info, see wiki:
https://github.com/DrakMelisek/pa165_haunted_houses/wiki

# REST description:

## POST /add
* Create person
* DATA example:
{"email”:”bill@gates.com”,”password”:”pass1234”, "admin”:”false”}

## DELETE /{id}
* Remove person

## GET /
* Return all People

## GET /{id}
* Return Person with id

## PUT /{id}
* Update Person
* DATA example:
{"email”:”bill@gates.com”,”password”:”pass1234”, "admin”:”false”}

