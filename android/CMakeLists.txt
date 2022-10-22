cmake_minimum_required(VERSION 3.4.1)

set (CMAKE_VERBOSE_MAKEFILE ON)
set (CMAKE_CXX_STANDARD 11)

add_library(Blake2bReact
            SHARED
            ../cpp/blake2b-react.cpp
            cpp-adapter.cpp
            ../BLAKE2-master/ref/blake2b-ref.c
)

# Specifies a path to native header files.
include_directories(
            ../cpp
            ../BLAKE2-master/ref
)
