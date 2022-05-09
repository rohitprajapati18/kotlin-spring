# kotlin-spring
cloudkart is a simple ecommerce application built on spring application using kotlin

### implementations so far
 - implemented mvc structure
 - Added get and add api endpoints for adding product and users
 - Containerised the application using docker


### entities
 - Product:\
   Product entities hold the information about the product in use
    - id (Long)
    - name (String)
    - category (String)
    - subcategory (String)
 - User:\
   Stores information about user register in the cloudkart
   -  id (Long)
   -  username (String)
   -  email (String)
   -  firstName (String)
   -  lastName: (String)
   -  dateOfBirth: (Date)
   -  gender (Enum Type : Gender)
