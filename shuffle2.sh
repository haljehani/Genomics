#!/bin/sh
for cell in Gm12878HMM 
do
		shuffle -o ./${cell}.bg.fasta ./${cell}.fasta
done
