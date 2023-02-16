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

First, create an instance of the ```CustomUiNetworkManager``` in your view model or any class that performs background operations.

```
private val customUiNetworkManager: CustomUiNetworkManager by lazy {
        CustomUiNetworkManagerImpl()
}
```

```CustomUiNetworkManager``` exposes two API calls that takes a custom URL as a parameter and return an appropriate response. Please adjust these calls to fit your specific requirements.

```
interface CustomUiNetworkManager {
    suspend fun fetchCustomUI(url: String): ApiResult<CustomUI>?
    suspend fun fetchLogo(url: String): ApiResult<String>?
}
```
Suppose, you are calling the API from your view model, you can fetch the result like this:

```
fun fetchCustomUi(url: String) {
        viewModelScope.launch {
            when(val response = customUiNetworkManager.fetchCustomUI(url)) {
                is ApiResult.Success ->  _customUi.value = response.data
                is ApiResult.Error ->  _errorHandling.value = response.exception?.message
                else -> _errorHandling.value = "Sorry, some error occurred"
            }
        }
    }
```
Because we wrapped the response inside a sealed class, it's easy to distinguish between a successful response and a failure response using an exception.

### Please note 

I'm using a temporary JSON bin to fetch the details. If the network call is failing using the sample app, you have to change the base URL from the Network module library and the end point point from the sample app.


### Find this repo useful 🤟?
Please star it 🌟 and follow me on __[LinkedIn](https://www.linkedin.com/in/clint-paul-2504bba7/)__ 

Also, do checkout my __[blog](https://clintpauldev.com/)__ for Android related articles.

