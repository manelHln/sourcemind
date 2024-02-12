# Assignment

## Assignment:

### Objectives:

- _be able to create Dockerfile_
- _be able to use nginx in Dockerfile_
- _be able to use apache2 in Dockerfile_
- _be able to use centos in Dockerfile_
- _be able to use Ubuntu in Dockerfile_

### Task:

- _Create Dockerfile for the last 2 assessement from Front-End Development course.
  There should be five types of Dockerfiles_
  _ Use for base image NGINX and copy site code in NGINX root directory, add Maintener line in your Dockerfile
  _ Use for base image Ubuntu, install there NGINX and copy site code in NGINX root directory, and when container start NGINX should start too, expose 80 and 443 ports, add Maintener line in your Dockerfile
  _ Use for base image Centos, install there NGINX and copy site code in NGINX root directory, and when container start NGINX should start too, expose 80 and 443 ports, add Maintener line in your Dockerfile
  _ Use for base image Ubuntu, install there apache2 and copy site code in apache2 root directory, and when container start apache2 should start too, expose 80 and 443 ports, add Maintener line in your Dockerfile \* Use for base image Centos, install there httpd and copy site code in httpd root directory, and when container start httpd should start too, expose 80 and 443 ports, add Maintainer line in your Dockerfile

---

### File Structure

- |- Assessement 1
- |- Assessement 2
- |- Dockerfile1
- |- Dockerfile2
- |- Dockerfile3
- |- Dockerfile4
- |- Dockerfile5

Ensure that after running a dockerfile I can access the assessement by navigating to:

- localhost/Assessement1/ -> I can see the assement 1
- localhost/Assessement2/ -> I can see the assement 2
- localhost/Assessement3/ -> I can see the assement 3
