# moviestore-rest

## Scaffolding
```
mkdir moviestore-rest
cd moviestore-rest
grails
```
### and once I get the prompt grails
```
create-app moviestore-rest --profile=rest-api
help
exit
```

## Create the domain resources:
```
grails
```
### and once I get the prompt grails
```
create-domain-resource moviestore.rest.data.Address
create-domain-resource moviestore.rest.data.Category
create-domain-resource moviestore.rest.data.City
create-domain-resource moviestore.rest.data.Content
create-domain-resource moviestore.rest.data.Country
create-domain-resource moviestore.rest.data.Customer
create-domain-resource moviestore.rest.data.Director
create-domain-resource moviestore.rest.data.District
create-domain-resource moviestore.rest.data.Inventory
create-domain-resource moviestore.rest.data.Iso3166
create-domain-resource moviestore.rest.data.Language
create-domain-resource moviestore.rest.data.Movie
create-domain-resource moviestore.rest.data.Payment
create-domain-resource moviestore.rest.data.Player
create-domain-resource moviestore.rest.data.Producer
create-domain-resource moviestore.rest.data.Rental
create-domain-resource moviestore.rest.data.Staff
create-domain-resource moviestore.rest.data.Store
```

### after adding properties, constraints and methods to each domain resource
```
generate-all moviestore.rest.data.Address
generate-all moviestore.rest.data.Category
generate-all moviestore.rest.data.City
generate-all moviestore.rest.data.Content
generate-all moviestore.rest.data.Country
generate-all moviestore.rest.data.Customer
generate-all moviestore.rest.data.Director
generate-all moviestore.rest.data.District
generate-all moviestore.rest.data.Inventory
generate-all moviestore.rest.data.Iso3166
generate-all moviestore.rest.data.Language
generate-all moviestore.rest.data.Movie
generate-all moviestore.rest.data.Payment
```
