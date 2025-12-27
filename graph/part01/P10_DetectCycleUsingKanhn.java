package com.graph.part01;

public class P10_DetectCycleUsingKanhn {

    /*
     * Topological sort is only possible for a DAG (Directed Acyclic Graph).
     *
     * If the size of the topological ordering is less than the number of nodes,
     * it means that some nodes could not be included in the ordering.
     *
     * The only possible reason for this is the presence of a cycle in the graph.
     *
     * Therefore:
     * 1. Perform topological sort.
     * 2. If topoSort.size() < number of vertices,
     *    then the graph contains a cycle.
     */
}
