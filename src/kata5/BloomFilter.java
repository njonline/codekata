package kata5;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.BitSet;

import static java.lang.Math.log;
import static java.lang.Math.pow;

/**
 * Implement a Bloom Filter, checking for occurrences of a specific word in a dictionary.
 */
public class BloomFilter {

    private int size;
    private int hash_count;
    private BitSet bitSet;
    private HashFunction hashFunction;

    /**
     * Constructor for our Bloom Filter implementation.
     * When this constructor is called, the calculation of optimal Bloom Filter size and number of hashes,
     * is automatically carried out on the basis of the params.
     * @param expected_num_items of the filter.
     * @param probability of false positive expressed as decimal number.
     */
    public BloomFilter(int expected_num_items, double probability) {
        this.size = calc_size(expected_num_items, probability);
        this.hash_count = calc_num_hashes(expected_num_items, this.size);
        this.bitSet = new BitSet(size);
    }

    /**
     * Add a new entry to our Bloom Filter.
     * This method hashes the String in n different ways, depending on the hash_count - which is calculated on the basis
     * of expected entries and the size of the filter. See {@link #calc_num_hashes(int, int)} and {@link #calc_size(int, double)}
     * The Murmur3 hashing method takes a seed-number as a parameter,
     * that allows us to vary the hash code of the input String in our Bloom Filter n-number of times.
     * @param input is the String to be added. Formatted to lowerCase, as to avoid negatives based on case.
     */
    public void add_entry(String input) {
        for(int i = 0; i <= hash_count; i++) {
            hashFunction = Hashing.murmur3_32(i);
            int output = Math.abs(hashFunction.hashString(input.toLowerCase(), Charset.defaultCharset()).asInt()) % size;
            bitSet.set(output);
        }
    }

    /**
     * Check an entry in our Bloom Filter.
     * @param input is the String to be checked. Formatted to lowerCase, as to avoid negatives based on case.
     * This method uses a counter to check whether all bits are set.
     * There should be a better way of checking, but my brain hurts.
     */
    public void check_entry(String input) {
        int counter = 0;

        for(int i = 0; i <= hash_count; i++) {
            hashFunction = Hashing.murmur3_32(i);
            int output = Math.abs((hashFunction.hashString(input.toLowerCase(), Charset.defaultCharset()).asInt())) % size;
            if(!bitSet.get(output)) counter++;
        }

        if(counter > 0) {
            System.out.println("Nope, not in this set man.");
        } else {
            System.out.println("Yup, probably in set");
        }
    }

    /**
     * Small utility method for calculating the optimal size of our Bloom Filter.
     * @param expected_num_items in the set
     * @param probability of false positives expressed as decimal number
     * @return the optimal size of the Bloom Filter
     */
    private int calc_size(int expected_num_items, double probability) {
        return (int) Math.ceil((expected_num_items * log(probability)) / log(1.0 / (pow(2.0, log(2.0)))));
    }

    /**
     * Small utility method for calculating the optimal number of hashes in our Bloom Filter.
     * @param expected_num_items in the set
     * @param size_of_filter of false positives expressed as decimal number
     * @return the optimal number of hashes
     */
    private int calc_num_hashes(int expected_num_items, int size_of_filter) {
        return (int) Math.round(log(2.0) * size_of_filter / expected_num_items);
    }

    public int getSize() {
        return size;
    }

    public int getHash_count() {
        return hash_count;
    }
}
