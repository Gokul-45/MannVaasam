import os
from fastapi import FastAPI
from pydantic import BaseModel
app=FastAPI(title="MannVaasam AI")
class Chat(BaseModel):
    message:str
    context:dict={}
@app.post("/api/ai/chat")
def chat(req:Chat):
    if not req.message.strip(): return {"reply":"Please enter a question."}
    return {"reply":"MannVaasam assistant fallback: I can help with agriculture products, marketplace usage, delivery-area rules and general farming questions. For crop-specific advice, verify recommendations with a qualified local agricultural professional."}