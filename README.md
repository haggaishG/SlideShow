
# SlideShow

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Platform](https://img.shields.io/badge/platform-Android-green)
![Kotlin](https://img.shields.io/badge/language-Kotlin-blue)

## 🚀 Introduction

**Slide Show** is a home project for NoviSign assessments

The exercise is fully defined in this link https://github.com/vladimir-nvs/slideshow-task-android



## 🛠️ Technologies Used

- **Kotlin** - Primary programming language.
- **Android SDK** - Platform for building the app.
- **Patterns In Use** - MVVM, Core Routines,
- **Other Libraries/Frameworks** - Retrofit, Glide, LiveData,




## Notes
- The application looks much nicer in Landscape mode
- The application doesn't always work with the emulator due to issues with the emulator not granting WiFi access from the computer

## Known Issues
- I did not write automatic unit tests, if I did, they would mainly be around the handling of odd JSON input such as empty lists, etc
- The crossfade animation is not working nicely

## Discussion
- **In Code Comments** I tend to write as few comments in the code as possible. From my experience, with time the code goes through an evolution of changes, and the comments, in most cases, do not get updated, and in a lot of cases, the out-of-date comments are more confusing than useful. I therefore prefer to use meaningful names and break the code into granulated small routines, to make it extra readable. I use comments **Only when I do non-standard things in the code** so later developers can understand the trick.
- **List Update** The application is loading the playlist only once. A nice addition to the application is for the View Model to attempt to re-fetch the list periodically in the background and replace the existing one.  Alternatively, it can perform the re-fetch attempt when it finishes playing the list
- **Reusability** The implementation is done directly in the MainActivity. A cleaner and reusable way is to wrap the visual functionality  in a dedicated Fragment and instantiate the fragment in the MainActivity
- **Parametrize for Reusability** The URLs are hard coded in the code, a nicer way is to enable customizing them as custom XML layout parameters for the fragment
- **Flexible Display Time** The display time for each visual is currently fixed and hard coded. However, in the JSON object there are parameters for display time that can be used for display time instead of the hard code
- **Cross Fade** The crossfade animations should have been handled at the **ExchangeContainer** class level, to make it cleaner and nicer, I did not  get to implement it
