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

https://github.com/arrking/com.arrking.hyqclient

## Engineering 


### Installations 
* Install Java SDK 7, Apache Ant, Android Dev Kit, IntelliJ IDEA 13+
* #TODO
## Implementation of hyqclient

hyqclient's backend is [hyqserver](https://github.com/arrking/com.arrking.hyqserver). It hosts the data and serve the management console. Only Admin user can login [hyqserver](https://github.com/arrking/com.arrking.hyqserver).

