# ClubHop
*An app to view Facebook events on Google Maps*
  <br/>
    <br/>

# REQUIREMENTS
Must be using Android 5.0.2 and above, and API 21 and above. The ClubHop team tests their app on a Google Pixel XL (Nougat 7.1.1 API 25), and on a Nexus 7 (Marshmallow 6.0.1 API 23).
  <br/>
    <br/>
# Running the App
1. Open terminal and do a git clone of this repository
2. Open the ClubHop project folder in Android Studio
3. Plug in your Android device via USB (or skip this step if using an emulator)
4. Click the green play button in the toolbar to start the app. You'll have a selection of devices to choose from.

<img src="http://i.imgur.com/tkizRbi.png" width="800px" />
  <br/>
    <br/>
      <br/>
        <br/>

**Choose the device you want to use (whether emulator or physical) and wait for the app to build and run itself**

<img src="http://i.imgur.com/q9Busuc.png" width="800px" />
  <br/>
    <br/>
      <br/>

1. The app should launch after a few minutes. On the location request popup, tap "allow"
2. The first screen is a Facebook login button. Upon successful login, ClubHop will ask Facebook for the events you have been invited to (excluding the ones you marked "can't go" or "ignore"). It parses the JSON from the API call and initializes its own local copy of your events, then displays them on the map view. **You need a Facebook account in order to make use of the app.**

<img src="http://i.imgur.com/VreEDMk.png" width="450px" />
  <br/>
    <br/>
      <br/>

# Using the App

**Welcome to ClubHop! The app should now center in on your location and show you nearby events.**

<img src="http://i.imgur.com/f9hrV1z.png" width="450px" /> <img src="http://i.imgur.com/5PiPHRw.png" width="450px" />
**NOTE** Events without locations will not appear on the map, so make sure that your event has a location set.
If you need directions to the event, tap the blue arrow button in the corner to open Google Maps navigation.
  <br/>
  <br/>
  <br/>


**Tap the marker and its info window to see more information about the event.**

<img src="http://i.imgur.com/1aHKfSN.png" width="450px" />
  <br/>
  <br/>
  <br/>


**Use the filter menu in the upper right corner to only display specific events. In this case, there are no events marked 'maybe' in my area**

<img src="http://i.imgur.com/aw4RveZ.png" width="450px" /> <img src="http://i.imgur.com/eMhq53o.png" width="450px" />
  <br/>
  <br/>
  <br/>


**Swipe left to view the settings pane. From here, you can change the map style, log out, or return to the map view**

<img src="http://i.imgur.com/sdnuHMJ.png" width="300px" /><img src="http://i.imgur.com/cNGOEiV.png" width="300px" /> <img src="http://i.imgur.com/MYK8UGS.png" width="300px" />
  <br/>
  <br/>
  <br/>


**All done**
<img src="http://i.imgur.com/KxvV6ND.png" width="450px" />
  <br/>
  <br/>
  <br/>
  
## FIXED BUGS
:beetle: Previously, if the user switched to a different app and then returned to ClubHop, they would have to log out and log back in for ClubHop to display their events again. Our team abstracted out the API calls so that the map can be populated in all kinds of situations (like when you're multitasking on your phone)

:beetle: We used to only be able to display events that the user marked 'attending', or 'maybe'. ClubHop now makes a second request to Facebook so the user can see events that they were invited to, but did not respond to yet. This functionality enables us to perhaps implement buttons that can allow a user to change their attending status directly from our app.

  <br/>
  <br/>
  <br/>


## KNOWN BUGS
:ant: switching quickly between filters makes the toast update kinda slow
