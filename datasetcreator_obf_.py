import os
import csv
import pandas as pd
from embeddings import encode_java_code, calculate_tokens

def save_obf_to_csv(inf_data_csv, root_directory, output_csv):
    # Read the design pattern mapping file
    df = pd.read_csv(inf_data_csv)
    
    with open(output_csv, 'w', newline='', encoding='utf-8') as csvfile:
        # Header: Directory, File, DesignPattern, Feature_0 ... Feature_255
        header = ["Directory", "File", "DesignPattern"] + [f"Feature_{i}" for i in range(256)]
        csv_writer = csv.writer(csvfile)
        csv_writer.writerow(header)
        
        for idx, row in df.iterrows():
            directory = row['Directory']
            source_file = row['SourceFile']
            obf_directory = row['ObfDirectory']
            design_pattern = row['DesignPattern']
            
            # Find the obfuscated .java file in decompiled_file
            decompiled_folder = os.path.join(root_directory, obf_directory, "decompiled_file")
            if not os.path.isdir(decompiled_folder):
                print(f"Missing decompiled_file folder: {decompiled_folder}")
                continue
            obf_files = [f for f in os.listdir(decompiled_folder) if f.endswith('.java')]
            if len(obf_files) != 1:
                print(f"Expected one .java file in {decompiled_folder}, found: {obf_files}")
                continue
            obf_file_path = os.path.join(decompiled_folder, obf_files[0])
            
            with open(obf_file_path, 'r', encoding='utf-8') as file:
                file_content = file.read()
            
            if calculate_tokens(file_content) < 2400:
                # Use obfuscated file name (without .java) for File column
                obf_file_base = os.path.splitext(obf_files[0])[0]
                # Compute embedding
                file_embeddings = encode_java_code(file_content)
                file_embeddings_list = file_embeddings.tolist()
                # Write row
                row_out = [directory, obf_file_base, design_pattern] + file_embeddings_list
                csv_writer.writerow(row_out)
            else:
                print(f"Skipped (too many tokens): {obf_file_path}")

if __name__ == "__main__":
    inf_data_csv = "obf_proguard_dpd/DPD_Att_inf_data.csv"
    root_directory = "obf_proguard_dpd"
    output_csv = "obf_classifier_34.csv"
    save_obf_to_csv(inf_data_csv, root_directory, output_csv)
    print(f"Dataset saved to {output_csv}")