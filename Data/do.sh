#!/bin/bash

cat mids2 | perl -n -e '$cnt=$cnt+1;if(/(.*)/) {print "update order_details set  movie_id = ".($1%27+1)." where movie_id=$1;\n"}'
