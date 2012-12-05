#!/bin/sh
for cell in Gm12878HMM 
do
	for state in 5_StrongEnhancer 6_WeakEnhancer  7_WeakEnhancer  8_Insulator  9_TxnTransition 10_TxnElongation 11_WeakTxn 12_Repressed 13_Heterochrom_lo 14_Repetitive_CNV 15_Repetitive_CNV
	do
		shuffle -o ./Data/${cell}/${state}.${cell}.bg.fasta ./Data/${cell}/${state}.${cell}.fasta
	done
done
