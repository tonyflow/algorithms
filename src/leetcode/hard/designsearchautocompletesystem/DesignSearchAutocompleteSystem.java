package leetcode.hard.designsearchautocompletesystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with
 * a special character'#'). Foreach character they type except '#', you need to return the top 3 historical hot sentences
 * that have prefix the same as the part of sentence already typed. Here are the specific rules:
 * 1. The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 * 2. The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences
 * have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
 * 3. If less than 3 hot sentences exist, then just return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 */
public class DesignSearchAutocompleteSystem {



}
