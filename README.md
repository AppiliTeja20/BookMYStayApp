# 🏨 Book My Stay App
## Use Case 3: Centralized Room Inventory Management

---

## 📌 Project Overview

This use case introduces **centralized inventory management** in the Hotel Booking Management System.

Instead of storing room availability in scattered variables, this version uses a **HashMap** to maintain a single source of truth for all room availability data.

This demonstrates how proper data structures improve:
- Scalability
- Consistency
- Maintainability
- Performance

---

## 🎯 Objective

- Replace independent availability variables
- Introduce `HashMap<String, Integer>`
- Centralize inventory management
- Provide controlled access and updates to availability
- Maintain separation of concerns

---

## 🛠 Technologies Used

- Core Java
- HashMap (java.util)
- Object-Oriented Programming (OOP)

---

## 🧠 Key Concepts Demonstrated

- Abstract Class (`Room`)
- Inheritance (`SingleRoom`, `DoubleRoom`, `SuiteRoom`)
- Encapsulation (Inventory logic inside `RoomInventory`)
- HashMap for centralized state management
- O(1) average time complexity for lookup and updates
- Single Source of Truth

---

## 📂 Project Structure (Single File Version)

```
UseCase3InventorySetup.java
```

Classes included:
- Room (Abstract Class)
- SingleRoom
- DoubleRoom
- SuiteRoom
- RoomInventory
- UseCase3InventorySetup (Main Class)

---

## 🚀 How to Compile and Run

### Step 1: Compile
```bash
javac UseCase3InventorySetup.java
```

### Step 2: Run
```bash
java UseCase3InventorySetup
```

---

## 📄 Sample Output

```
Hotel Room Inventory Status

Single Room:
Beds: 1
Size: 250 sqft
Price per night: 1500.0
Available Rooms: 5

Double Room:
Beds: 2
Size: 400 sqft
Price per night: 2500.0
Available Rooms: 3

Suite Room:
Beds: 3
Size: 750 sqft
Price per night: 5000.0
Available Rooms: 2
```

---

## ✅ Benefits Over Previous Use Case

- Eliminates scattered availability variables
- Prevents inconsistent updates
- Improves scalability
- Easier to add new room types
- Centralized and maintainable design

---

## 📌 Version

**Version 3.0**

---

## 👨‍💻 Author

Developer