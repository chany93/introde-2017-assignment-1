# introde-2017-assignment-1

Giovanni Rafael Vuolo 
giovannirafael.vuolo@studenti.unitn.it


The code is structure in two packages inside the src folder: model (where there are the People and Activity classes) and people (all the others). Outside the src folder there are the people.xml (with 20 persons), the people.xsd, the ivy.xml and the build.xml.

In XPathPeople.java there is the function for printing the list of the person from the people.xml (getPeople()), the function for getting the preferred activity of a person (getActivityPreference(Integer)), the function for getting the person with a specific startdate (get.ActivitybyStartdate(Date, String)) and finally getActivityDescription(Integer) and getActivityPlace(Integer) which do as the name says.
JAXBMarsh.class does the marshalling creating NewPeople.xml
JAXBUnmarsh.class does the unmarshalling of people.xml
PeopleJSON.class does the JSON transformation


In order to excecute the application from forking it to run it, follow this steps:

- Click on "Fork" in the upper right corner of the page

- on your terminal go to a folder of your choosing
- write $ git clone https://github.com/chany93/introde-2017-assignment-1


Now you can compile/run it with:

- $ cd introde-2017-assignment-1

- $ ant execute.evaluation
this will run XPathPeople.class, JAXBMarsh.class, JAXBUnmarsh.class and PeopleJSON.class
it will show every output from the excecuted classes on console and will create NewPeople.xml (output of the marshalling) and people.json (output from the JSON transformation)

Another way to run it is using Eclipse (given that you have Ivy installed):

- open project in Eclipse
- right-click on ivy.xml -> "Add Ivy Library"
- refresh the project
- right-click build.xml -> Run as -> 2 Ant Build 
- compile command should be default select also execute.evaluation (the order of execution should be compile, execute.evaluation) -> "Run"





