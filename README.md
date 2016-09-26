#FindMyPet!

##Contributors

[Matthew Duffin] (https://duffin22.github.io/) - Android Developer

[Severin Rudie] (https://www.linkedin.com/in/severin-rudie) - Android Developer

[Michael M Kang] (michaelmkang.com) - Android Developer

[Brian Sasville] (https://www.linkedin.com/in/bpsasville) - UX Designer

[Diana Artalejo] (https://www.linkedin.com/in/deartalejo) - UX Designer

[Jillian Ryan] (https://www.linkedin.com/in/jilianryan) - UX Designer

<p align="left">
<img style="padding: 100px" src="./screenshots/home_page.png" width="200">
<img style="padding: 100px" src="./screenshots/recycler.png" width="200">
<img style="padding: 100px" src="./screenshots/detail_screen.png" width="200">
</p>

##Description

This app was written over 24 hours as an entry for a Socrata hackathon where the goal was to write a compelling application using a public City of Seattle API.  The primary function of this entry, which won said hackathon, is to pull down information regarding lost cats and dogs recovered by the city, then display it in a readable format.

Whenever a user searches for a lost pet, the database checks whether the current information is fewer than 12 hours old.  If not, the current information is dropped and the API queried again.  Located pets are then displayed to the user according to queries made to the local database, which may be modified by the user using a search bar.

The user may search using any of the following information, and it is displayed for each animal: breed; gender; name; picture; color; region found.  Also shown (but not searchable) are the date found by the city, shelter address, shelter contact information, and animal ID.  Calling the appropriate shelter may be done with the push of a button.

In the case of a resident locating a lost animal, the app will open an official webpage where its location may be reported.  Additionally, a list of tips regarding lost pets is available.

Finally, a pet profile contains information about a users pet.  This is intended to store specific information that can be easily uploaded to a city website if the animal is ever lost, but at this time the data is mocked.

