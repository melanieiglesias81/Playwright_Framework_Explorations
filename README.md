# Playwright_Framework_Explorations

# Playwright Python Automation Framework

A fast, reliable, and modern end-to-end test automation framework built using **Playwright** and **Python**. This repository follows industry best practices to deliver resilient UI automation with built-in auto-waiting and network interception capabilities.

Documentation: https://playwright.dev/python/docs

## 🚀 Key Features

* **True Multi-Browser Testing:** Supports Chromium (Chrome/Edge), WebKit (Safari), and Firefox out of the box.
* **Auto-Wait Mechanics:** Automatically waits for elements to be actionable before performing tasks, drastically reducing flaky tests.
* **Parallel Execution:** Powered by `pytest-xdist` to execute multiple tests concurrently for rapid feedback.
* **Trace Viewer & Video Recording:** Easily records test videos, screenshots on failure, and full execution traces for deep debugging.
* **API Testing Integration:** Capable of making direct API calls alongside UI workflows within the same test context.

---

## 🛠️ Prerequisites

Before setting up the project, make sure you have the following installed on your system:

* **Python 3.8 or higher:** [Download Python](https://python.org) *(Ensure you check the box to "Add Python to PATH" during installation).*
* **IDE / Code Editor:** [VS Code](https://visualstudio.com) or [PyCharm](https://jetbrains.com) is highly recommended.
* **Git:** For version control management.

---

## ⚙️ Installation & Setup

Follow these step-by-step instructions to get your local development environment running:

### 1. Clone the Repository
Open your terminal or command prompt and run:
```bash
git clone https://github.com
cd your-repo-name
```

### 2. Create and Activate a Virtual Environment (Recommended)
To keep the project dependencies isolated and avoid conflicts with global Python packages, set up a virtual environment:

* **On Windows:**
  ```bash
  python -m venv venv
  .\venv\Scripts\activate
  ```
* **On macOS/Linux:**
  ```bash
  python3 -m venv venv
  source venv/bin/activate
  ```

### 3. Install Python Dependencies
Ensure your virtual environment is active, then upgrade `pip` and install all required testing libraries:
```bash
pip install --upgrade pip
pip install -r requirements.txt
```

*(Note: If you do not have a `requirements.txt` yet, the basic libraries can be installed via `pip install playwright pytest pytest-playwright`)*

### 4. Install Playwright Browsers
Unlike standard Selenium setups, Playwright manages its own binaries. Run the following command to download the required browser engines:
```bash
playwright install
```

---

## 🏃 Running the Tests

This framework uses `pytest` as the test runner. You can execute your scripts directly from the command line while your virtual environment is active:

```bash
# Run all tests
pytest

# Run tests on a specific browser (default is chromium)
pytest --browser firefox
pytest --browser webkit

# Run tests in headed mode (visible browser window)
pytest --headed

# Run tests in parallel across 3 workers
pytest -n 3

# Capture screenshots, video, and traces on failure
pytest --screenshot=only-on-failure --video=retain-on-failure --trace=retain-on-failure
```

---

## 📁 Project Structure

```text
├── .gitignore               # Files and folders ignored by Git (e.g., venv/, test-results/)
├── requirements.txt         # List of required Python packages and libraries
├── pytest.ini               # Global Pytest configuration file
├── README.md                # Project documentation
├── pages/                   # Page Object Model (POM) classes
│   ├── base_page.py         # Shared methods and helper wrappers
│   ├── login_page.py        # Login UI selectors and element actions
│   └── dashboard_page.py    
├── tests/                   # Actual test scripts (.py files matching test_*.py)
│   ├── conftest.py          # Fixtures for browser context setup and teardown
│   ├── test_auth.py         
│   └── test_dashboard.py    
└── test-results/            # Automatically generated videos, traces, and screenshots (Git-ignored)
```

---

## 📑 Debugging and Tracing

If a test fails and you ran it with the `--trace=retain-on-failure` flag, a `trace.zip` file will be saved in the `test-results/` directory. You can inspect the full recording step-by-step by opening it via the terminal:

```bash
playwright show-trace test-results/your-failed-test-folder/trace.zip
```
