# Towards Benchmarking Design Pattern Detection Under Obfuscation

This repository accompanies the paper:  

**“Towards Benchmarking Design Pattern Detection Under Obfuscation: Reproducing and Evaluating Attention-Based Detection Method”**  
Accepted at **AISA 2025**, co-located with **ECSA 2025**.

---

## 📁 Dataset Overview

- **Original Subset**  
  34 Java source files (2–3 per pattern, covering 13 design patterns including “Unknown” samples), manually curated from the DPD_Att corpus.

- **Obfuscated Subset**  
  The same 34 Java files, systematically obfuscated to remove naming-based syntactic signals (class names, method names, variable names) while preserving program logic, control flow, and inheritance structures.

- **Mapping Files**  
  Obfuscator-generated mapping files to match obfuscated class names back to their original names, enabling reproducibility of labels for evaluation.

---

## ⚙️ Requirements

- Python 3.X (preferably 3.12)  
  [https://www.python.org/downloads/](https://www.python.org/downloads/)

---

## 📂 Folder Descriptions

- **codet5p/**  
  Contains CodeT5+ model and embedding resources:  
  - `codet5p-110m-embedding/`: Pretrained embedding files for CodeT5+  
    - `tokenizer_config.json` with `model_max_length` set to 2400  
  - Also available at: [Hugging Face - CodeT5+](https://huggingface.co/Salesforce/codet5p-110m-embedding/tree/main)

- **cross_valid_model_256/**  
  Contains trained classifier models with 256-dimensional embeddings from 5-fold cross-validation:  
  - `Logistic_Regression.pkl`  
  - `Multi-layer_Perceptron.pkl`  
  - `Support_Vector_Machine.pkl`

- **DPD_Att/**  
  The original Java source code corpus, organized into project folders.

- **obf_proguard_dpd/**  
  Contains obfuscated Java project directories and files, created for evaluation under systematic name-based obfuscation.  
  - `obfu/`, `obfu2/`, ... : subfolders for different Java source files  
    - Includes ProGuard configuration `config.pro`  
    - Obfuscated output packages as `obfuscated_project.jar`  
    - Mapping files as `out.map`

- **trained_models_256/**  
  Stores pre-trained models using 256-dimensional embeddings.

---

## 🗝️ Key Files and Usage Notes

- `embeddings.py` — script to extract embeddings from Java source files  
- `obf_classifier_34.csv` — classifier outputs for the 34-file obfuscated test set  
- `datasetcreator.py`, `datasetcreator_obf_.py` — scripts for generating classifier datasets for the original and obfuscated subsets respectively  
- `DPD_Att_Classifier_256.csv` — generated using `datasetcreator.py` and used for training  
- `DPD_Att.csv` — labeled CSV dataset representing 1554 Java files of the DPD_Att corpus  
- `model_t5p_256_Run.ipynb`, `cross_valid_256.ipynb` — additional notebooks for model training and validation  
- `inference_results_CV_7_34.csv` — inference results for the obfuscated benchmark (34 Java files)  
- `run_inference_cross_valid.ipynb` — notebook to run inference and evaluate classifiers  
- `feature_names.pkl` — pickled feature names for consistent feature extraction  
- `label_classes.npy` — NumPy array of label classes for encoding/decoding  
- `confusion_matrix_inf.png` — visualization of confusion matrix at inference for obfuscated vs ground truth

---

**Note:**  
The full DPD_Att corpus is not redistributed here due to licensing. Please contact the original authors for access to the complete dataset. Only the curated subsets and benchmarks prepared for this study are included.  

---

If you’d like, I can help you adapt this even further for Zenodo or Figshare if you plan to archive it!
