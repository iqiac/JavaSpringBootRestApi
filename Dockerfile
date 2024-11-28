# ===============================================================================
FROM fedora:latest AS base

ENV JAVA_VERSION=latest
ENV GRADLE_VERSION=8.11.1

# Dependencies for building
RUN dnf install -y \
    java-${JAVA_VERSION}-openjdk-devel \
    maven
RUN dnf upgrade -y && dnf clean all

# ===============================================================================
FROM base AS developer

# Dependencies for development
RUN dnf install -y \
    git \
    tree \
    tmux \
    helix \
    zsh \
    fzf \
    xclip \
    xsel
RUN dnf upgrade -y && dnf clean all

# Create user
ARG USER
ARG UID
ARG GID
RUN groupadd -g ${GID} ${USER} \
    && useradd -u ${UID} -g ${GID} -m ${USER} -s /bin/zsh
USER ${USER}

# Install oh-my-zsh
RUN sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"

ENTRYPOINT [ "zsh" ]