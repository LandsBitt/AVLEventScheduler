# AVLEventScheduler 🌳🕒

**AVLEventScheduler** is a Java implementation of a self-balancing AVL tree designed for managing events with conflict-free time scheduling. The project organizes events by their unique IDs, ensures no time overlaps, and supports efficient insertion, deletion, and querying operations.

---

## Features

- **Self-Balancing AVL Tree**: Maintains a height difference of at most 1 between subtrees for optimal performance.  
- **Event Management**: Stores events with unique IDs, start times, end times, and descriptions.  
- **Time Conflict Detection**: Prevents insertion of events with overlapping time slots.  
- **Query Operations**:  
  - List all events sorted by ID (in-order traversal).  
  - Retrieve events starting at a specific time.  
  - Retrieve events within a specified time range.  
- **Event Removal**: Delete events by start time.  
- **Command-line Interface**: Simple interaction via terminal.

---

## Prerequisites

- Java Development Kit (JDK) 8 or higher  
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or terminal for compilation and execution

---

## Installation

1. **Clone the repository**  
```bash
git clone https://github.com/LandsBitt/AVLEventScheduler.git
```

2. **Navigate to the project directory**  
```bash
cd AVLEventScheduler
```

3. **Compile the Java source files**  
```bash
javac -d . src/org/example/*.java
```

4. **Run the main class**  
```bash
java org.example.Main
```

---

## Usage

The program processes commands from standard input to manage events.

### Supported Commands

- `ADD <event_id> <start_time> <end_time> <description>`  
  Inserts a new event with the specified details.

- `QUERY_TIME <start_time>`  
  Lists events that start at the given time.

- `QUERY_RANGE <start_time> <end_time>`  
  Lists events within the specified time range.

- `PRINT_INORDER`  
  Displays all events sorted by ID.

- `REMOVE <start_time>`  
  Removes an event by its start time.

---

## Example

**Input**
```
3
ADD 1 10 12 Meeting
ADD 2 13 15 Presentation
PRINT_INORDER
```

**Output**
```
Evento com ID 1 inserido com sucesso.
Evento com ID 2 inserido com sucesso.
ID: 1, descrição: Meeting, Inicio:10, Fim:12
ID: 2, descrição: Presentation, Inicio:13, Fim:15
```

---

## Project Structure

```
AVLEventScheduler/
├── src/
│   └── org/
│       └── example/
│           ├── Btree.java      # AVL tree implementation
│           ├── Bnode.java      # AVL node with balancing and event operations
│           ├── Evento.java     # Event class for storing event details
│           └── Main.java       # Command-line interface for user input
├── README.md
```

---

## Code Overview

- **Evento.java**  
  Defines the `Evento` class with fields for event ID, start time, end time, and description, including getters, setters, and a copy constructor.

- **Bnode.java**  
  Implements AVL tree nodes with balancing logic (rotations, height management) and methods for event insertion, deletion, and querying.

- **Btree.java**  
  Manages the AVL tree, delegating operations to the root node.

- **Main.java**  
  Handles command-line input and executes user commands.

---
