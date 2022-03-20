# moviestore-graphql-api

## application developed to provide a complete and understandable description of the data exposed in the API, thanks to the GraphQL language

### I start the new project with the scaffolding of the application:

```shell
mvn io.quarkus:quarkus-maven-plugin:2.7.5.Final:create -DprojectGroupId=local.moviestore -DprojectArtifactId=moviestore-graphql-api -DclassName="local.moviestore.MoviestoreAtWorkResource" -Dextensions="resteasy,graphql,quarkus-hibernate-validator,quarkus-jdbc-mariadb,quarkus-hibernate-orm-panache" -DnoExamples -DbuildTool=gradle
```

### I start a test session with:

```shell
./gradlew test
```

### I start a test native session with:

```shell
./gradlew testNative
```

### how to get a list of extensions available with:

```shell
./gradlew listExtensions
```

### for example, once I find the extension that interests me, I proceed with adding this dependency:

```shell
./gradlew addExtension --extensions="extension_name_of_interest"
```

### now I can start the application in development mode:

```shell
./gradlew quarkusDev
```

## at this point, requesting resource /graphql/schema.graphql on localhost port 8080, I get:

```shell
type Address {
  civic: String
  district: District
  id: BigInteger
  name: String
  phone: String
  residents: [Customer]
  staff: [Staff]
  stores: [Store]
  type: String
  "ISO-8601"
  updated: DateTime
}

type Category {
  description: String
  id: BigInteger
  movies: [Movie]
  name: String
  "ISO-8601"
  updated: DateTime
}

type City {
  country: Country
  districts: [District]
  id: BigInteger
  name: String
  "ISO-8601"
  updated: DateTime
}

type Content {
  id: BigInteger
  movies: [Movie]
  subject: String
  "ISO-8601"
  updated: DateTime
}

type Country {
  cities: [City]
  id: BigInteger
  iso3166: Iso3166
  name: String
  "ISO-8601"
  updated: DateTime
}

type Customer {
  active: Boolean
  "ISO-8601"
  birthday: String
  customerAddress: Address
  customerStore: Store
  email: String
  id: BigInteger
  mobile: String
  name: String
  nickname: String
  payments: [Payment]
  phone: String
  rentals: [Rental]
  surname: String
  "ISO-8601"
  updated: DateTime
}

type Director {
  id: BigInteger
  movies: [Movie]
  name: String
  nickname: String
  surname: String
  "ISO-8601"
  updated: DateTime
}

type District {
  addresses: [Address]
  city: City
  code: String
  id: BigInteger
  name: String
  "ISO-8601"
  updated: DateTime
}

type Inventory {
  id: BigInteger
  inventoryStore: Store
  movie: Movie
  rentals: [Rental]
  "ISO-8601"
  updated: DateTime
}

type Iso3166 {
  code: Int
  countries: [Country]
  id: BigInteger
  name: String
  signature: String
  "ISO-8601"
  updated: DateTime
}

type Language {
  id: BigInteger
  movies: [Movie]
  name: String
  "ISO-8601"
  updated: DateTime
}

type Movie {
  categories: [Category]
  "ISO-8601"
  comeout: String
  contents: [Content]
  cost: Float
  description: String
  directors: [Director]
  "ISO-8601"
  duration: String
  id: BigInteger
  inventories: [Inventory]
  language: Language
  players: [Player]
  producers: [Producer]
  rating: Float
  rent: Float
  subtitle: String
  title: String
  "ISO-8601"
  updated: DateTime
}

type Payment {
  amount: Float
  id: BigInteger
  "ISO-8601"
  payed: String
  paymentCustomer: Customer
  paymentStaff: Staff
  rental: Rental
  "ISO-8601"
  updated: DateTime
}

type Player {
  id: BigInteger
  movies: [Movie]
  name: String
  nickname: String
  surname: String
  "ISO-8601"
  updated: DateTime
}

type Producer {
  id: BigInteger
  movies: [Movie]
  name: String
  nickname: String
  surname: String
  "ISO-8601"
  updated: DateTime
}

"Query root"
type Query {
  "returns a list of all addresses registered in the system"
  allAddresses: [Address]
  "returns a list of all categories registered in the system"
  allCategories: [Category]
  "returns a list of all cities registered in the system"
  allCities: [City]
  "returns a list of all contents registered in the system"
  allContents: [Content]
  "returns a list of all countries registered in the system"
  allCountries: [Country]
  "returns a list of all country codes registered in the system"
  allCountryCodes: [Iso3166]
  "returns a list of all customers registered in the system"
  allCustomers: [Customer]
  "returns a list of all districts registered in the system"
  allDistricts: [District]
  "returns a list of all inventories registered in the system"
  allInventories: [Inventory]
  "returns a list of all languages registered in the system"
  allLanguages: [Language]
  "returns a list of all movies registered in the system"
  allMovies: [Movie]
  "returns a list of all payments registered in the system"
  allPayments: [Payment]
  "returns a list of all players registered in the system"
  allPlayers: [Player]
  "returns a list of all rentals registered in the system"
  allRentals: [Rental]
  "returns a list of all staffs registered in the system"
  allStaffs: [Staff]
  "returns a list of all stores registered in the system"
  allStores: [Store]
}

type Rental {
  "ISO-8601"
  back: String
  customer: Customer
  id: BigInteger
  inventory: Inventory
  payments: [Payment]
  "ISO-8601"
  rent: String
  staff: Staff
  "ISO-8601"
  updated: DateTime
}

type Staff {
  active: Boolean
  email: String
  id: BigInteger
  mobile: String
  name: String
  nickname: String
  password: String
  payments: [Payment]
  phone: String
  rentals: [Rental]
  staffAddress: Address
  staffStore: Store
  surname: String
  "ISO-8601"
  updated: DateTime
  username: String
}

type Store {
  customers: [Customer]
  id: BigInteger
  inventories: [Inventory]
  name: String
  storeAddress: Address
  teams: [Staff]
  "ISO-8601"
  updated: DateTime
}

"Scalar for BigInteger"
scalar BigInteger

"Scalar for DateTime"
scalar DateTime

```
