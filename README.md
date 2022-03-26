# songr_Spring_Boot
### build project for music albums using Spring Boot framework, these steps to guide you to how you can run my projects


### you have to use this port => 8081

### route(root) : index page to say hello for now.
### Path (localhost:8081/)

<br>

### (/hello) route to say hello for everyone using hello.html...:->
### Path (localhost:8081/hello/)
### (/hello?name=aya) route to say hello for aya using hello.html...:->
### Path (localhost:8081/hello?name=aya)

<br>

### (/capitalize/this is Kinda Capitalized) route to capitalize String you have capitalize.html...:->
### Path (localhost:8081/capitalize/this is Kinda Capitalized)

<br>

### (/Albums) route to show 3 albums at least as JSON data.
### Path (localhost:8081/Albums)


<br>

### (/GetAllAlbums) route to get Albums data from DataBase (The user will enter the data using the form and click on submit to send data for the database called"lab12")
#### you have to start the server using (psql) command and enter to your table (my table : lab12)
#### you have to use this route to test:- (http://localhost:8081/GetAllAlbums)

<br>

### (/Albums) route to get all Albums with its songs using JSON.
### Example: (http://localhost:8081/GetAllAlbums/33) to get the data from album 33.

