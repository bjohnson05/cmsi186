# Git Essentials Cheat Sheet - CMSI 186

This "Quick Reference" page is intended to help you get up and running with the GitHub command line, which is the preferred way that experienced programmers use GitHub.
Thanks to Teddy Chu [of the class of 2019] for putting this together!

Note that if you are not familiar with the command line, console, or terminal window operation, you can find basic help at Dr. Johnson's website at [this link.](http://bjohnson.lmu.build/cmsi186web/commands.html)

## Installation
### On Mac computers:
1. open a terminal window and execute the following command:
1. $ git --version
1. you will be prompted to install git if it's not already there.
1. just follow the prompts

### On Windows computers:
1. point a browser to [this download link](https://git-scm.com/download/win)
1. save the file to your hard drive
1. virus scan the file for insurance
1. open the file by double-clicking it
1. if asked to provide administrator privilege, do so
1. click "Next"
1. click "Next" again
1. select from the selections
1. click "Next"
1. select "Vim" and click "Next" 
1. ....there's still a few more instructions to visit here......
1. ...
1. run the Git Bash program

## Configuring a Repository
1. *$ git config --global user.name "[git user name]"* to set your user name to what you want to see in your commits.<br />Use your GitHub user name.  Use the quotes, but NOT the brackets.
1. *$ git config --global user.email "[your email address]"* to set your user e-mail address to what you want to see in your commits.<br />Use your GitHub account e-mail.  Use the quotes, but NOT the brackets.

## Creating a Repository
1. *$ git init [repo-name]* to create a new local repository with the specified name **on your local machine in your current working directory**<br />BE SURE you are in the directory [or folder] where you want this repo to be located on your local machine
2. *$ git clone [URL]* to download a copy of the repository with its entire version history **onto your local machine in your current working directory**<br />BE SURE you are in the directory [or folder] where you want this data to go

## Synchronizing Changes
* Notes on what follows:
  * To upload new versions of your code to GitHub, you will "push" the changes.
  * To download new versions of your code to your local computer, you will "pull" the data.
  * To "lock in" the changes, you will "commit" them.  You should always add a "commit message".
  * GitHub maintains the "old" versions of your files so when you commit a change, the latest file is the one you will see.  The older versions are "behind the scenes" but will be saved and are accessible if you want/need them.

1. *$ git status* shows any and all new/modified files that need to be committed.
1. *$ git add [file]* adds a new file to the list of files whose changes will be tracked by GitHub.  Note that this adds the file **to the list being tracked**, NOT necessarily to this particular commit.
1. *$ git add .* adds **all** the files in the directory to the list to be tracked.  Note the "dot" character, meaning the current local working directory.
1. *$ git commit -m "[message]"* STAGES all tracked changes to be committed.<br />the "-m" switch tells GitHub you are including a "commit message".<br />You SHOULD do this for all your commits!
1. *$ git push* pushes the commits [staged files] to the repo on the remote computer.
1. *$ git pull* pulls all new/changed files from the remote GitHub repo to your local machine.<br />*Make sure you do this before continuing work on a project*, EXPECIALLY if you have collaborators on your repo.

## Final Note
This is NOT an exhaustive list of git commands!  If you want to get the most out of git, consider checking out a full quick reference [cheat sheet] from [this link!](https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf)

Enjoy your new GitHub knowledge!
