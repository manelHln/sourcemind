# Assignment

## Assignment 1:
### Approximate Duration: _30 minutes_
### Objectives: 
* _be able to compressing files_ 
* _be able to archive files and folders_

### Task:
* _Use this commands to copy kern.log and boot.log files to home directory "sudo cp /var/log/kern.log ~/.; sudo cp /var/log/boot.log ~/."_
* _Compresed the kern.log file usinz gzip_
* _List the compressed file_
* _Ucomptresed the compressed file_
* _Create archive file from kern.log and boot.log files using zip command_
* _Extract the created archive files in /tmp directory using zip command_

---
## Assignment 2:
### Approximate Duration: _30 minutes_
### Objectives: 
* _be able to use head and tail commands_ 

### Task:

* _Print first seven lines numbers-en.txt file_
* _Print first 3 bytes numbers-en.txt file_
* _Print numbers-en.txt and numbers-fr.txt first 7 lines files_
* _Print last seven lines numbers-en.txt file_
* _Print first 3 bytes numbers-en.txt file_
* _Print numbers-en.txt and numbers-fr.txt first 7 lines files_
* _Run the append_test.sh file: Every second it appends the current timestamp to a log file (/tmp/timestamp.log), it will append to the log file ten times:_
* _Watching the /tmp/timestamp.log log-file by tail command_

---
## Assignment 3:
### Approximate Duration: _30 minutes_
### Objectives: 
* _be able to filter file contents_
* _be able to use regular and extended expressions_

### Task:
* _Search in the newhome.txt file "the" word_
* _Search in the newhome.txt file "the" letter combination_
* _Search in the newhome.txt file "are" letter combination and return lines which contain that_
* _Search root in "/etc/passwd" file_
* _Serach root in "/etc/passwd" file where lines begin with root word_
* _Search sync in "/etc/passwd" file_
* _Serach sync in "/etc/passwd" file where lines end with sync word_
* _Execute the command to attempt to match either sshd, root and operator words in "/etc/passwd" file_
* _Execute the command to attempt to match the strings nob and non in "/etc/passwd" file_

---
## Assignment 4:
### Approximate Duration: _30 minutes_
### Objectives: 
* _be able to provides a snapshot of the memory used at that moment_
* _be able to view processes_
* _be able to view processes in real time_
* _be able to kill the processes_

### Task:

* _Print a snapshot of memory used at that moment and redirect the output in the memory_usage.txt file_
* _Print processes and redirect the output in the process.txt file_
* _Print load average and redirect the output in the loadaverage.txt file_
* _Use man command to investigate kill command_
* _Use man command to investigate jobs command_
* _Run this command "ping localhost > /dev/null &" and use kill command to kill process_
* _Run this command "ping localhost > /dev/null &" and use top command to kill the ping process_
* _Run this command "ssh localhost" and use tail command to see "/var/log/auth.log" file end 20 lines"

> Note: After all assigment use history command and write the output to homework-2-command.txt file.