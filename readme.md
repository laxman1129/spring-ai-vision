# Spring AI Vision

This project is to a POC for checking the feasibility of using Spring AI for vision tasks.

## get vision model from huggingface
```bash
ollama run hf.co/bartowski/ibm-granite_granite-vision-3.2-2b-GGUF
```


## Observations 
- `minicpm` model is comparatively best for vision tasks
- `llava` model is better at reading number plates compared to minicpm
- `granite-vision` model is very basic
- `moondream` model is small vision model and can be used for simple vision tasks

---
## References
- https://www.udemy.com/course/spring-ai-beginner-to-guru/learn/lecture/43721904#overview
