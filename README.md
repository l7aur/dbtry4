# Elden Ring related database + GUI

#### ([Inspiration](https://eldenring.wiki.fextralife.com/Elden+Ring+Wiki) unbelievably worse Fextralife in every single aspect) 


This is the mandatory project required for the database course (DB) in the second year at Technical University of 
Cluj-Napoca. Its purpose is to familiarize one with the SQL language, the most common sql servers, and an IDE 
(DBeaver or DataGrip).

## Table of Contents

- [Description](#Description)
  - [Preliminaries](#Preliminaries) 
  - [Screens](#Screens)
  - [Database](#Database)
- [Installation](#installation)
- [Usage](#usage)
- [Further developments](#Further-developments)
- [License](#license)

## Description

### Preliminaries

The project is composed of three main elements: 
- the GUI made in Java and JavaSwing 
- the backend database based on postgres
- the connection between them based on the JDBC driver

The purpose of the project is to simulate insertion of reviews of specific items from a database under some general 
assumptions (basic CRUD operations).  

### Screens

The GUI is composed of 8 "screens" (pages, frames):
- Home Screen 

    The first screen that appears when the application is run. Contains 7 buttons that change the screen to another specific
    screen depending on what button is pressed. The buttons are implemented as images that aim to reflect visually what each
    of them redirects to. 
    <br></br>

- Other Screens
  - Boss Screen
  - Weapon Screen
  - Armor Screen
  - Incantation Screen
  - Sorcery Screen
  - Character Screen
  - Comment Screen
  
  These screens display the data taken from the table that is part of the database. All these screens contain a **home
button** that changes the screen back to the home screen and an **insert comment button** that opens a pop-up window: ![](img.png)
Here, the user can fill in this form that is saved in the **comments** table inside the database. No filtering of the comment text is
done, but the table is equipped with a trigger that checks if the id of the item the comment targets exists inside those
specific tables. Every screen but the home one is equipped with the **insert comment button** to make it easier to get the id
of the item the user tries to comment on (the id is case-sensitive and sometimes long enough to cause misspells, this concern
is partially solved by the ability to select fields inside the displayed table and copy-paste the information inside them into
the id field).

### Database


  
## Installation

Download the project, the dependencies, create the database, fill the database (TODO smth about this) and run the application 
in an IDE such as IntellijIdea.

## Usage

When the app is run this widow opens:
TODO add image ![image]()
Any button can be pressed.

## Further developments

Guidelines for contributors, including instructions for how to contribute, code of conduct, and the contribution process.

## License

Information about the project's license. Specify the type of license and include any necessary disclaimers or notices.

## Additional Sections (Optional)

All the images are available on the internet for free use. None is mine.
- Troubleshooting
- FAQs
- Credits
- Changelog
