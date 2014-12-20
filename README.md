# Hang Ye Quan App

## [Project white paper](https://github.com/arrking/com.arrking.doc/tree/master/bpo/hangyequan)

## Persona

### Peter - Admin

The administrator of Hang Ye Quan Platform. He can add/delete/block user, he can add/delete posts in different catergories - ads, job opennnig and news.

### Jacky - VIP User
Jacky is belong to VIP Groups, he can access information that common user may not have priviledges like avatar or phone number. VIP is created by Admin.

### Bob - Common User
Common user is the not logged in user. He can read news, ads, job opennings. But he can not get other information.

## Project Management 

https://github.com/arrking/com.arrking.tory

## Engineering 


### Installations 
* Install xCode, NodeJS

* Install cordova, ionic

```
sudo npm install cordova@3.6.3-0.2.13 -g
sudo npm install ionic@1.2.8 -g
sudo npm install ios-sim@3.0.0 cordova-lib@4.0.0 -g
sudo gem update --system && sudo gem install compass
sudo npm install generator-ionic@0.6.1 -g
sudo npm update -g yo # make sure yo@1.1.2
```

* Get source codes

```
git clone git@github.com:arrking/com.arrking.hyqclient.git
```

* Launch App

```
cd com.arrking.hyqclient
grunt plugins:add:https://github.com/driftyco/ionic-plugins-keyboard.git
grunt plugins:add:org.apache.cordova.statusbar
grunt plugins:add:org.apache.cordova.console
grunt plugins:add:org.apache.cordova.device
grunt platforms:add:android
grunt run:android
```

### Get started

* [Cordova](http://git.oschina.net/ubiware/tech-books/blob/master/apache-cordova-3-programming.pdf)
* [Ionic](http://ionicframework.com/)
* [AngularJS](http://git.oschina.net/ubiware/tech-books/blob/master/AngularJSIn60MinutesIsh_DanWahlin_May2013.pdf)


## Implementation of hyqclient

hyqclient's backend is [hyqserver](https://github.com/arrking/com.arrking.hyqserver). It hosts the data and serve the management console. Only Admin user can login [hyqserver](https://github.com/arrking/com.arrking.hyqserver).


## Android Commands
List Devices
```
adb devices
```

## Debugging
* Print logs

```
platforms/android/cordova/log | grep "Web Console"

OR

platforms/android/cordova/log > /tmp/and.log
tail -f /tmp/and.log| grep "Web Console"
```

* Launch App

```
grunt run:android
```

## Serve ```www``` 
```
grunt serve
```