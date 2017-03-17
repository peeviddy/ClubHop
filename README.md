================
# ClubHop
*An app to view Facebook events on Google Maps*

=================
# REQUIREMENTS
Must be using Android 5.0.2 and above, and API 21 and above. The ClubHop team tests their app on a Google Pixel XL (Nougat 7.1.1 API 25), and on a Nexus 7 (Marshmallow 6.0.1 API 23).

==================
# Running the App
1. Open terminal and do a git clone of this repository
2. Open the ClubHop project folder in Android Studio
3. Plug in your Android device via USB (or skip this step if using an emulator)
4. Click the green play button in the toolbar to start the app. You'll have a selection of devices to choose from.

<img src="http://i.imgur.com/tkizRbi.png" width="800px" />

**Choose the device you want to use (whether emulator or physical) and wait for the app to build and run itself**

<img src="http://i.imgur.com/q9Busuc.png" width="800px" />

1. The app should launch after a few minutes. On the location request popup, tap "allow"
2. The first screen is a Facebook login button. **To get the full ClubHop experience, log in with your Facebook account**

**NOTE:** map will only populate with markers upon successful login

<img src="http://i.imgur.com/VreEDMk.png" width="450px" />

**Welcome to ClubHop! The app should now center in on your location and show you nearby events.**

<img src="http://i.imgur.com/f9hrV1z.png" width="450px" />

**Feel free to scroll around and tap on events you would like to attend.**

<img src="http://i.imgur.com/5PiPHRw.png" width="450px" />

**Tap the marker and its info window to see more information about the event.**

<img src="http://i.imgur.com/1aHKfSN.png" width="450px" />

**Use the filter menu to only display specific events.**

<img src="http://i.imgur.com/aw4RveZ.png" width="450px" />

**No events marked 'maybe' in my area**

<img src="http://i.imgur.com/eMhq53o.png" width="450px" />

**Swipe left to view the settings pane**

<img src="http://i.imgur.com/sdnuHMJ.png" width="450px" />

**Tap settings and change the map style**

<img src="http://i.imgur.com/cNGOEiV.png" width="450px" />

**Ooooh so retro**

<img src="http://i.imgur.com/MYK8UGS.png" width="450px" />

**Log out when you're done! (not necessary)**

<img src="http://i.imgur.com/KxvV6ND.png" width="450px" />

Previously, if the user switched to a different app and then returned to ClubHop, they would have to log out and log back in for ClubHop to display their events again. Our team abstracted out the API calls so that the map can be populated in all kinds of situations (like when you're multitasking on your phone)

==================
# KNOWN BUGS
:ant: switching quickly between filters makes the toast update kinda slow
