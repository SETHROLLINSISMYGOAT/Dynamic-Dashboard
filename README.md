My Approach: When building this, my main focus was on Widget Identity. Since the backend sends a list of widgets, I needed a way to make sure that two "List Widgets" didn't overwrite each other's data. I solved this by using the instanceId from the metadata as a unique key for the ViewModels. This ensures that "Movies" and "Shows" stay completely independent.

Key Decisions:

Sealed Classes for State: I chose a sealed class for the UI state because it forced me to handle the Loading, Success, and Error cases explicitly in the UI.

LaunchedEffect: I used LaunchedEffect(Unit) to trigger the data fetch. I did this to make sure the 2-second delay only happens once when the widget first appears, rather than every time the screen re-renders.

Stateless Banners: I kept the Banners "stateless" to keep the code clean. They just take data and show it, which makes them very easy to reuse.

Trade-offs & Future Improvements:

Static Data: Since I didn't have a real API, I built ListDataGenerator to simulate a network. In a real app, I'd move this to a Repository with Retrofit.

Loading UI: I used a standard CircularProgressIndicator for now. If I had more time, I would implement a Shimmer effect to make the UI feel smoother during the 2-second wait.
