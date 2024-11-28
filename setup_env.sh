#!/bin/bash

USER_NAME=$(whoami)
USER_UID=$(id -u $USER_NAME)
USER_GID=$(id -g $USER_NAME)

echo "USER=$USER_NAME
UID=$USER_UID
GID=$USER_GID" > .env

exit 0