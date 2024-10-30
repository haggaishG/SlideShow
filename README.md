
# SlideShow

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Platform](https://img.shields.io/badge/platform-Android-green)
![Kotlin](https://img.shields.io/badge/language-Kotlin-blue)

## 🚀 Introduction

**Slide Show** is a home project for NoviSign assesmets

The excersize is fully defined in this link https://github.com/vladimir-nvs/slideshow-task-android



## 🛠️ Technologies Used

- **Kotlin** - Primary programming language.
- **Android SDK** - Platform for building the app.
- **Patterns In Use** - MVVM, Core Routines,
- **Other Libraries/Frameworks** - Retrofit, Glide, LiveData,




## Notes
- The application looks much nicer in Landscape mode
- The application doesn't allways work with emulator due to issues with emulator not granted WiFi access from the computer

## Known Issues
- I did not write automatic unit tests, if I did, they would mainly be around the handling of odd json input such as empty lists etc
- The cross fade animation is not working nicely

## Discussion
- **In Code Commets** I tend to write as little commets in the code as possible. From my experience, with time the code is going through evolution of changes, and the comments, in most cases, do not get updated, and in a lot of cases the out of date commets are more confusing than usefull. I terefore prefare to use meaningful names and break the code to well granulated small routines, to make it extra readable. I use commets **Only when I do non standard thing in the code** so later developers can understand the trick.
- **List Update** The application is loading the playlist only once. A nice addition to the application is for the View Model to attempt to refetch the list periodically in the background and replace the existing one.  Alternatively it can perform the refetch attempt when it finishes to play the list
- **Reusability** The implementation is done directly in the MainActivity. A cleaner and reusable way is to wrap the visual functionality  in a dedicated Fragment and instanciate the fragment in the MainActivity
- **Parametrize for Rusability** The URLs are hard coded in the code, a nicer way is to enable customizing them as custom xml layout parameters for the fragment
- **Flexible Display Time** The display time for each visual is currently fixed and hard coded. However, in the json object there are parameters for display time that can be used for display time instead of the hard code

