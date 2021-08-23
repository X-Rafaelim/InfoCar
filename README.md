# InfoCar 
![lastUpdate](https://img.shields.io/github/last-commit/X-Rafaelim/InfoCar)



## Introduction

InfoCar was an app designed to be evaluated as my final project in my professional course that in Portuguese is called PAP(Prova de Aptidão Profissional).

InforCar is an Android Phone APP about car information like :
* Horse Power
* Weight
* Num of doors

The project consists of a creation of a DataBase in MYSQL an API in PHP that runs on an AWS server and on the front-end I have a phone app that receives the information.


## DataBase

The Database is simple only have 3 tables that one contains the car brands the other the models of the cars and in the final table we have the information about the model.

Here is a photo of the DataBase

![DataBase!](Tabela.PNG "DataBase InfoCar")


## API

The API was made in PHP and runs on an AWS web server that was configurated on one instance using apache2, it only does GET methods and the GET returns all the information on the table, in the example below you can see the response that asks for the information about brands:

```
{
    "records": [
        {
            "idbrands": "1",
            "brand_name": "BMW",
            "image": "https://logosmarcas.net/wp-content/uploads/2020/04/BMW-Logo-2020-.....jpg"
        },
        {
            "idbrands": "2",
            "brand_name": "Mercedes",
            "image": "https://i.pinimg.com/originals/03/e1/b0/03e1b0207489ad32d10b9a860ffc6623.png"
        },
        {
            "idbrands": "3",
            "brand_name": "Renault",
            "image": "https://i.pinimg.com/originals/f5/ac/15/f5ac1518c0a97c0346fa3e82084ef9c0.jpg"
        },
        {
            "idbrands": "4",
            "brand_name": "Nissan",
            "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Nissan-logo.svg/1189px-Nissan-logo.svg.png"
        }
    ]
}
```
## Android APP

For the final step, we have the phone app that the only thing that the app does is show the information about the car models, and the user can see  a "menu" to choose the car brand and after the model from the brand 

## Future Updates

For some time I will not work on this app because I am taking mini-vacations, but the updates that the app needs and in the future will have is:

* Website to put the information in the DataBase
* Upgrade the code
* Add search bar
* Add filters to things like: HP, fuel type...
* And more things that I will think in the future
