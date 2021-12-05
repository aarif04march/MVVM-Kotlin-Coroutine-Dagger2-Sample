# MVVM-Kotlin-Coroutine-Dagger2-Sample
A sample application to illustrating the clean Architecture using Android Development Best Practices. This application is built on using the [JSON PlaceHolder](https://jsonplaceholder.typicode.com/) API which is a collection of dummyy json apis.

Introduction
------------

The application uses Clean Architecture based on MVVM and Repository patterns. Implemented
Architecture principles follow Google recommended [Guide to app architecture](https://developer.android.com/jetpack/docs/guide).

![Guide to app architecture](screenshots/MVVM-final-architecture.png "Guide to app architecture")

The application is written entirely in Kotlin.

Android Jetpack is used as an Architecture glue including but not limited to ViewModel, LiveData,
Lifecycles, Navigation, Room and Data Binding. See a complete list in "Libraries used" section.

The application does network HTTP requests via Retrofit, OkHttp and GSON. Loaded data is saved to
SQL based database Room, which serves as single source of truth and support offline mode.
Paging library is used for data pagination online and offline.

Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks.
Combination of Coroutines and Kotlin build in functions (transformation, collections) are preferred
over RxJava 2.

Work manager does synchronisation job being compatible with Doze Mode and using battery efficiently.
Navigation component manages in-app navigation.

Dagger 2 is used for dependency injection.

Glide is used for image loading and Timber for logging.

Libraries Used
---------------
* [Json PlaceHolder](https://jsonplaceholder.typicode.com/) - A Collection of json data used for sample application.
* [Architecture](https://developer.android.com/jetpack/arch/) - A collection of libraries that help you design robust, testable, and
maintainable apps. Start with classes for managing your UI component lifecycle and handling data
persistence.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* [LiveData](https://developer.android.com/jetpack/arch/livedata) - notify the view when data changes .
* [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes
* [Navigation](https://developer.android.com/topic/libraries/architecture/navigation) - Handle everything needed for in-app navigation.
* [AppCompat](https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat) - Degrade gracefully on older versions of Android.
* [Android KTX](https://developer.android.com/kotlin/ktx) - Write more concise, idiomatic Kotlin code.
* [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite database with in-app objects and compile-time checks
* [DataBinding](https://developer.android.com/topic/libraries/data-binding/) - bind UI components to data sources
* [Material](https://material.io/develop/android/docs/getting-started/) - Material Components.
* [Coroutine](https://github.com/Kotlin/kotlinx.coroutines#user-content-android) - performs background tasks
* [Retrofit2](https://square.github.io/retrofit/)- networking
* [Gson](https://github.com/google/gson) - convert Java Objects into their JSON and vice versa
* [Dagger2](https://dagger.dev/users-guide) - dependency injector
