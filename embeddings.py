import torch
from transformers import AutoModel, AutoTokenizer

device = "cuda" if torch.cuda.is_available() else "cpu"  # Set the device to cuda if available, else use CPU
checkpoint = "./codet5p/codet5p-110m-embedding"  # Path to the directory containing both pytorch_model.bin and config.json

# Load the tokenizer and model using the local path to pytorch_model.bin
tokenizer = AutoTokenizer.from_pretrained(checkpoint, local_files_only=True, trust_remote_code=True)
model = AutoModel.from_pretrained(checkpoint, local_files_only=True, trust_remote_code=True,ignore_mismatched_sizes=True).to(device)

#handle truncation directly to pass 2400 tokens 
#inputs = tokenizer.encode(code, return_tensors="pt", truncation=True, max_length=2400).to(device)


def calculate_tokens(code):
    inputs = tokenizer.encode(code, return_tensors="pt").to(device)
    size=len(inputs[0])
    return size    #inputs[0]


def encode_java_code(code):
    inputs = tokenizer.encode(code, return_tensors="pt").to(device)
    embedding = model(inputs)[0]
    return embedding
