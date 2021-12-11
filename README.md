# Katalon Test Automation (Case Study: FILKOM UB)

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/a/a6/Katalon_Studio_logo.png" width="250">
</p>

This is a repository for test automation project for FILKOM UB Website using Katalon Studio and integrated with Katalon TestOps Github Actions.

The purpose of this repo is to show you how we can automate web UI testing and run them automatically daily (or on-demand) using Katalon TestOps.

Katalon Studio is a free and easy-to-use automated functional and regression testing platform. It provides users the ability to implement full automated testing solutions for their application projects with minimal engineering and programming skill requirements.

## What does this project test?

This project just test the jadwal kuliah function on FILKOM UB website and changing the jadwal view by day.

## Structure

This project is developed using POM (Page-Object model). I'll try to explain in a simple manner:

#### Object Repository/

This folder contains **individual objects** (button, links, images, etc) that user can interact with. You can say it is the representation of actual elements on a page. It will be used by our test cases files. The directory structure should follow the actual path that contains that element (URL). For example:

- A button for download.
  
  **URL**: `http://mysite.com/software/downloads`
  
  **File path**: `Object Repository/software/downloads/btn_download`
- An image of user on profile page
  
  **URL**: `http://mysite.com/profile/`
  
  **File path**: `Object Repository/profile/img_profile`

#### Test Cases/pages/

This folder contains **individual actions** (clicking on a button, upload an image, select a checbox, etc). You can say it is the representation of actions that the user can do *on a particular page*. In doing so, it uses the object stored in `Object Repository`. The directory structure should follow the actual path that contains that element (URL). For example:

- Clicking button for download.
 
  **URL**: `http://mysite.com/software/downloads`
 
  **Test case file**: `Test Cases/pages/software/downloads/click download button`

- Upload image of user on profile page
 
  **URL**: `http://mysite.com/profile/`
 
  **File path**: `Test Cases/pages/profile/upload user image`

#### Test Cases/actions/

This folder contains **a set of actions** (ex: going to user profile page, and then change profile picture). You can say it is a representation of **a user's intention** when using the website. In doing so, it uses the test cases in `Test Cases/pages/`. The directory structure should represent the user journey or test suites. For example:

- Changing profile picture (part of User Settings Journey)
  
  **Steps**: call `click user profile button`, call `upload user image`, call `assert upload user image success`
  
  **File path**: `Test Cases/actions/user settings journey/as a user, i can change my profile picture`

#### Test Suites

This folder contains **a set of related actions** (ex: change user profile picture, change password, change name, all on user setting page). You can say it is a representation of **a user's journey** when using the website. In doing so, it uses the test cases in `Test Cases/actions/`. The directory structure should represent the user journey or test suites. For example:

- User Settings Journey
  
  **Contains**: `as a user, i can change my profile picture`, `as a user, i can change my username`, `as a user, i can change my password`
  
  **File path**: `Test Suites/user profile journey/user profile journey`

## Development

### Prerequisites
- Download Katalon Studio 8xx
- Install Chrome
- A good internet access

### Setting Up
- Clone this repository
- [Open](https://docs.katalon.com//display/KD/Manage+Test+Project) project from Katalon Studio
- Update your drivers: *Menubar > Tools > Update WebDrivers.*

### Executing a Test Case/Test Suite

![Execute a simple test case](https://github.com/katalon-studio-samples/tips-and-tricks/blob/master/Tutorials/Figures/Execute%20test%20case%20tips%20and%20tricks.png?raw=true)

1. Expand Test Cases/Test Suite in Tests Explorer
2. Select the test case/suite you want to execute (double-click)
3. Click the play button near top right of the screen to execute using default browser (Chrome), or select a different browser.
