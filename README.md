# A PROPOS (ABOUT):
    ## Fr:
        - Ce projet est dédié à DEVSLING Consulting en France. C'est un projet pour développer 
        une application Spring Boot back-end qui s'appelle "Car Sales Garage" pour la
        création des web services REST (REST APIs).
    --------------------------------------------------------------------------------------
    ## Eng:
        - This project is dedicated to DEVSLING Consulting in France. It is a project to develop
        a Spring Boot back-end application called "Car Sales Garage" for the
        Creation of REST API Web Services.

# Base de Données (Database):
    ## Fr:
        - Supposant que le port est par défaut 8080 comme le port de l'application Spring Boot.
        - Pour lancer la base de données H2 sur le navigateur, utiliser ce lien dans le navigateur => http://localhost:8080/h2-console
        - SI "JDBC:URL" est par défaut "~/test" dans l’interface de connexion de la base de données H2 => changez-le manuellement en "~/car-sales-garage-db" & connectez-vous.
        - Copier & Coller les requetes SQL dans le fichier "schema.sql" et les executer pour créer les tables dans 
          la base de données. Puis faire le même avec le fichier "data.sql" pour avoir quelques jeux de données.
    --------------------------------------------------------------------------------------
    ## Eng:
       - Assuming the default port is 8080 as the port of the Spring Boot application.
       - To launch the H2 Database on Browser hit this link in the browser => http://localhost:8080/h2-console
       - IF "JDBC:URL" is by default "~/test" in the H2 databse login interface => change it manually to "~/car-sales-garage-db" & connect.
       - Copy & Paste the SQL requests in the file "schema.sql" and execute them to create the tables in
         database. Then do the same with the file "data.sql" to have some datasets.

# Comment lancer l'application ? (How do I launch the app?):
    ## Fr:
        - Allez au fichier "SpringBootCarSalesGarageRestapiApplication.java" sous le répertoire "src/...." et lancer
          l'application depuis le flèche en vert.
        - La coccinelle pour lancer le mode debug.
        - Aprés avoir lancer l'application en mode normal ou debug, allez dans un client REST comme POSTMAN,
          et tester les web services REST sous l'URL de base => http://localhost:8080/car-sales-garage-restapi/
        - Note : Exemple de la façon dont le post du "RequestBody" en tant que données "raw JSON" du client POSTMAN par exemple :
              {
                ....
                "make": "Lamborghini",
                "model": "Gallardo",
                ...
              }
    --------------------------------------------------------------------------------------    
    ## Eng:
       - Go to the "SpringBootCarSalesGarageRestapiApplication.java" file under the "src/...." directory and launch
         the application from the green arrow.
       - The ladybug to start debug mode.
       - After launching the application in normal or debug mode, go to a REST client like POSTMAN,
         and test the REST web services under the base URL => http://localhost:8080/car-sales-garage-restapi/
       - Note: Example of how the post the "RequestBody" as "raw JSON" data from the POSTMAN Client for example:
            {
                ....
                "make": "Lamborghini",
                "model": "Gallardo",
                ...
            }

# Services Web API REST (REST API Web Services):
    ## Fr / Eng:
        - Get All Garages Catalogs from db => http://localhost:8080/car-sales-garage-restapi/garage-catalogs
        - Get All Cars from db => http://localhost:8080/car-sales-garage-restapi/cars
        - Get All Cars By Fuel Type And Max Price from db => http://localhost:8080/car-sales-garage-restapi/cars/{fuel-type}/{max-price} (fuel-type eg.: DIESEL | max-price eg.: 17500)
        - Get All Makes Available In the Catalog from db => http://localhost:8080/car-sales-garage-restapi/cars/all-makes
        - Add / Create new Car to the Catalog of Cars and Save it to the H2 db => http://localhost:8080/car-sales-garage-restapi/cars/createNewCar
                |--> Ici, nous devrions publier le "RequestBody" en tant que données "raw JSON" du client POSTMAN, par exemple
                    (Here we should post the "RequestBody" as "raw JSON" data from the POSTMAN Client, for example):
                        {
                            ....
                            "make": "Lamborghini",
                            "model": "Gallardo",
                            ...
                       }
        - Update Existing Car by ID => http://localhost:8080/car-sales-garage-restapi/cars/updatePicUrlExistingCar/{id-car} (id-car eg.: 3)
                |-> Même que la précedente "RequestBody" en tant que données "raw JSON", par exemple
                    (Same as previous "RequestBody" as "raw JSON" data, for example):
                        {
                            "picture": "resources/static/images/3__2017-Golf-7-updated.jpg"
                        }

# Comment lancer les test ? (How to launch the tests?):
    ## Fr: 
        - Allez au fichier "SpringBootCarSalesGarageRestapiApplicationTests.java" sous le répertoire "test/...." et lancer
          l'application depuis le flèche en vert.
        - La coccinelle pour lancer le mode debug.
        - Mon fichier "CarGarageAppTest.java" sous le même répertoire "test/...." a des tests spécifiques.
    ## Eng:
        - Go to the "SpringBootCarSalesGarageRestapiApplicationTests.java" file under the "test/...." directory and launch
          the application from the green arrow.
        - The ladybug to start debug mode.
        - My "CarGarageAppTest.java" file under the same "test/...." directory has specific tests.

# Pour des informations complémentaires ? (Would you like more information?):
    ## Fr:
        - Contactez-moi sur mon LinkedIn: https://www.linkedin.com/in/walid-zhani-54705612a/
        - Contactez-moi sur mon Github: https://github.com/ZhaniWalid
        - Contactez-moi sur mes Emails: walid.zhani24@gmail.com || walid.zhani@esprit.tn 
    # Eng:
        - Contact me on my LinkedIn: https://www.linkedin.com/in/walid-zhani-54705612a/
        - Contact me on my Github: https://github.com/ZhaniWalid
        - Contact me on my Emails: walid.zhani24@gmail.com || walid.zhani@esprit.tn


## BIG GREETINGS FROM "WALID ZHANI", FROM "TUNISIA"