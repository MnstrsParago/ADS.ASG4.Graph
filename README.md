# 📁 Graphs

**Subject:** Algorithms and Data Structures  
**Name:** Ayazbek Abdanur

## 📌 Project Description

This project focuses on graph-based algorithms and data structures, implemented with a custom object-oriented approach. Instead of treating vertices and edges as primitive data, each **`Vertex`** holds its own adjacency map, creating a more modular and flexible graph model.

The project includes full implementations of:

* Breadth-First Search (BFS)
* Dijkstra's Shortest Path Algorithm
* Graph structure using Vertex objects with weighted adjacency

The goal was to build a graph model that aligns with real-world graph concepts while ensuring compatibility with standard search algorithms.

## 💡 Features

* ✅ Custom `Vertex<V>` class with adjacency management
* ✅ `WeightedGraph<V>` class using a vertex-to-vertex mapping
* ✅ Breadth-First Search (BFS) traversal
* ✅ Dijkstra Search with distance tracking
* ✅ Flexible and reusable design
* ✅ Fully compatible with the structure of the reference [GitHub Main.java](https://github.com/aghia7/example/tree/master/src)

## 📦 Technologies

* Java 17
* Object-Oriented Design
* Graph Theory Concepts
* Collections Framework

## 🚀 How to Run

1. Clone the repository

   ```bash
   git clone https://github.com/MnstrsParago/ADS.ASG4.Graphs.git
   ```
2. Open in your IDE or compile via terminal:

   ```bash
   javac *.java
   java Main
   ```

## 📘 Reflection

Building this project gave me a deeper appreciation for how visual structures like graphs can be translated into logic. It was especially interesting to implement algorithms like BFS and Dijkstra using vertex-based adjacency instead of edge lists.

At first, the idea of abstracting edges into vertices seemed unintuitive — but as I worked through the logic, it became clear how elegant and scalable this model can be. The challenge was more conceptual than syntactical, and I’m glad I took the time to break it down and fully understand the inner workings of graphs.
