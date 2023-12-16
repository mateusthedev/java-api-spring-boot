-- Table to store user information
CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    situation BOOLEAN NOT NULL
);

-- Table to store project information
CREATE TABLE projects (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    creatorUserId VARCHAR(36),
    FOREIGN KEY (creatorUserId) REFERENCES Users(id),
    situation BOOLEAN NOT NULL
);

-- Table to associate users with projects (many-to-many)
CREATE TABLE usersProjects (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    userId VARCHAR(36),
    projectId VARCHAR(36),
    permission INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (projectId) REFERENCES projects(id)
);

-- Table to store task information
CREATE TABLE tasks (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    projectId VARCHAR(36),
    FOREIGN KEY (projectId) REFERENCES projects(id),
    situation INT NOT NULL -- 1 - Open / 2 - In Progress / 3 - Code Review / 4 - Completed
);

-- Table to associate users with tasks (many-to-many)
CREATE TABLE usersTasks (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    userId VARCHAR(36),
    taskId VARCHAR(36),
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (taskId) REFERENCES tasks(id)
);