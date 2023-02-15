<h1 align="center"> NetWorkManager </h1>
<p align="center">
  🕸️ A library module where you can handle network requests for your app
</p>

### Why I created the network manager? 
I created the network manager for several reasons. 
* Firstly, I needed a dedicated module to handle my network requests, which would reduce coupling from the app side and make my codebase more organized. 
* Additionally, by exposing only the necessary APIs to the app side, I could streamline the development process and make my code more maintainable. 
* Moreover, separating the network logic from the UI allowed me to split my team and have specialists work on each aspect. 
* Lastly, I could easily share this module with others by uploading it as a package or using it as an .aar file in my app. 

#### Please note that this is not a general-purpose tool, but rather a sample tutorial to showcase the benefits of separating modules for a single purpose.

### How to use from the app module? 

First, create an instance of the ```CustomUiNetworkManager``` in your view model or any class you do the background operation.

```
private val customUiNetworkManager: CustomUiNetworkManager by lazy {
        CustomUiNetworkManagerImpl()
}
```

```CustomUiNetworkManager``` exposes two API calls that takes a custom URL as a param and gives appropriate response. ( Please change it according to your requirement )

```
interface CustomUiNetworkManager {
    suspend fun fetchCustomUI(url: String): ApiResult<CustomUI>?
    suspend fun fetchLogo(url: String): ApiResult<String>?
}
```
