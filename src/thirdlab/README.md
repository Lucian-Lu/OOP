<h1>Third Laboratory </h1>

---
<h3>Monitoring and detecting changes in documents within a designated folder</h3>

Possible operations:
* commit - update the snapshot (time at which the status is checked)
* info <filename> - view info about a file's proprieties (using inheritance & polymorphism!)
* status - view the status of all the files at the time of the snapshot in the designated directory

Other features:
* status -> no change, changed, new file, deleted
* threading -> thread dedicated to checking for updates within directory, every 5 seconds; if a change is found, its printed in the console.