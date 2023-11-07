import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
  timeout: 3 * 60 * 1000,

  expect: {
    timeout: 15 * 1000,
  },

  testDir: './tests',
  fullyParallel: true,
  forbidOnly: !!process.env.CI,
  retries: 1,
  workers: process.env.CI ? 1 : undefined,
  reporter: 'html',

  use: {
    trace: 'retain-on-failure',
    headless: true,
    actionTimeout: 15 * 1000,
    navigationTimeout: 30 * 1000,
    screenshot: 'only-on-failure'
  },

  projects: [
    {
      name: 'chromium',
      use: { ...devices['Desktop Chrome'] },
    },
  ],
});
