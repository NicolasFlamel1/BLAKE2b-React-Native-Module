// Header guard
#ifndef BLAKE2B_REACT_H
#define BLAKE2B_REACT_H


// Header files
#include <vector>

using namespace std;


// Function prototypes

// Compute
vector<uint8_t> compute(double resultSize, const uint8_t *input, size_t inputSize, const uint8_t *key, size_t keySize);


#endif
