# moviestore-web

## scaffolding
```
mkdir moviestore-web
cd moviestore-web
grails
```
### and once I get the prompt grails
```
create-app moviestore-web --profile=web
```

## create the domain resources:
```
grails
```
### and once I get the prompt grails
```
create-domain-class moviestore.web.data.Address
create-domain-class moviestore.web.data.Category
create-domain-class moviestore.web.data.City
create-domain-class moviestore.web.data.Content
create-domain-class moviestore.web.data.Country
create-domain-class moviestore.web.data.Customer
create-domain-class moviestore.web.data.Director
create-domain-class moviestore.web.data.District
create-domain-class moviestore.web.data.Inventory
create-domain-class moviestore.web.data.Iso3166
create-domain-class moviestore.web.data.Language
create-domain-class moviestore.web.data.Movie
create-domain-class moviestore.web.data.Payment
create-domain-class moviestore.web.data.Player
create-domain-class moviestore.web.data.Producer
create-domain-class moviestore.web.data.Rental
create-domain-class moviestore.web.data.Staff
create-domain-class moviestore.web.data.Store
```

### and now, after adding properties, constraints and methods to each domain resource, I add everything else
```
generate-all moviestore.web.data.Address
```
