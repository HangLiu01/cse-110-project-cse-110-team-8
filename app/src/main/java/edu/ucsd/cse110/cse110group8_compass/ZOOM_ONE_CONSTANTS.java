package edu.ucsd.cse110.cse110group8_compass;

import android.util.Pair;

/*
    Zone 1: [0-1 mile)
    Zone 2: [1-10 miles)
    Zone 3: [10-500 miles)
    Zone 4: [500 miles, 500 miles +)
 */
class ZOOM_ONE_CONSTANTS
{
    final public int OUTER_CIRCLE_RADIUS = 170;
    final public int ZONE_ONE = 70;
    final public int ZONE_ONE_STACK = 140;

    final public Pair<Integer, Integer> TRUNCATE_RANGE = Pair.create(85, 95);

}
