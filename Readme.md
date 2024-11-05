# 🔗 Graphs in Java

A graph is a data structure consisting of a collection of nodes (also called vertices) connected by edges. Graphs are versatile and can represent various real-world connections like social networks, computer networks, or city maps.

## 📚 About

This repository provides implementations for graph data structures and basic operations on them. Graphs can be **directed** (edges have a specific direction) or **undirected** (edges are bi-directional). Each type has its specific use cases, such as network routing or relationship modeling.

### 🗝️ Key Concepts:

- **Vertices (Nodes)**: Fundamental units of the graph.
- **Edges (Links)**: Connections between vertices.
- **Directed Graph**: Edges have a direction, indicating a one-way connection.
- **Undirected Graph**: Edges don’t have direction, indicating a two-way connection.
- **Weighted Graph**: Each edge has an associated weight or cost.

## 🏗️ Graph Representations

1. **Adjacency Matrix**:

   - Uses a 2D array to store connections between nodes.
   - `matrix[i][j] = 1` (or the weight) if an edge exists from vertex `i` to vertex `j`.

2. **Adjacency List**:
   - Each vertex has a list of its connected vertices.
   - Efficient in memory usage, especially for sparse graphs.

## 🚀 What we'll Learn

- Graph representation with adjacency matrix and adjacency list
- Depth-First Search (DFS) and Breadth-First Search (BFS) traversals
- Cycle detection for both directed and undirected graphs
- Topological Sort and it's Applications
- Pathfinding and shortest path algorithms (Dijkstra's, Bellman-Ford)
- Minimum spanning tree (MST) algorithms (Kruskal’s, Prim’s)

## 🌐 Additional Resources

For more understanding, you can refer to these resources:

- [Graph Youtube Playlist by Striver](https://youtube.com/playlist?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&si=etlxBMPP6zpJeKXc)
- [GFG - Graph Data Structure](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)

---

Happy coding!