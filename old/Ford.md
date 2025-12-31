DOR and DOD
DOR- Everthing is ready to take the ticket
DOD- Everthing is completed in ticket with documentation


Agile cerimony
Backlog refinement, Sprint planning, Sprint review, Retrospective and Daily standup


Commands in docker

# Build a Docker image from a Dockerfile.
#This command will build a Docker image named my-image with the tag latest. The image will be built from the Dockerfile in the current directory.
docker build -t my-image:latest .

# Run a Docker container from an image.
docker run -d --name my-container my-image:latest

# List all running Docker containers.
docker ps

# Stop a running Docker container.
docker stop my-container

# Remove a Docker container.
docker rm my-container

# List all Docker images.
docker images

# Remove a Docker image.
docker rmi my-image:latest

# Login to a Docker registry.
docker login docker.io

# Push a Docker image to a registry.
docker push docker.io/my-username/my-image:latest

# Pull a Docker image from a registry.
docker pull docker.io/library/nginx

# Execute a command in a running Docker container.
docker exec my-container echo "Hello from Docker!"



Differenc between copy and add in docker command
Both commands are used to copy the file or directory from host to docker image
Both need soruce and destination input
COPY <src> <des>
ADD <src> <des>


COPY

The COPY instruction copies files or directories from the host machine to the Docker image at the specified destination path. It can copy files from any location on the host machine, including the current directory, other directories, and even remote URLs.

ADD

The ADD instruction is similar to the COPY instruction, but it has a few additional features. First, the ADD instruction can extract compressed files, such as tarballs and zip files. Second, the ADD instruction can download files from remote URLs.


Docker Volume
Its is Directory or file to store data. This is useful for data that needs to be shared between multiple containers, or data that needs to be persisted even if the container is stopped or removed.


Metaspace

Metaspace is not a fixed size memory region, but rather a dynamic one that can grow or shrink as needed
Metaspace contains Class metadata, Constant pool information, Method bytecode


Horizontal vs vertical scaling

Horizontal scaling in Kubernetes involves adding more nodes to the cluster  
Vertical scaling is adding more resources to your existing servers. This can include adding more CPU cores, memory, storage, or network bandwidth.
