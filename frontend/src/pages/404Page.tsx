import { Link } from "react-router";

export default function NotFoundPage() {
  return (
    <main className="grid w-screen h-screen place-items-center dark:bg-gray-900 bg-slate-50 px-6 py-24 sm:py-32 lg:px-8">
      <div className="text-center">
        <p className="text-2xl font-semibold text-blue-600">404</p>
        <h1 className="mt-4 text-5xl font-semibold tracking-tight text-balance dark:text-white text-slate-700 sm:text-7xl">
          Page not found
        </h1>
        <p className="mt-6 text-lg font-medium text-pretty text-gray-400 sm:text-xl/8">
          Sorry, we couldn’t find the page you’re looking for.
        </p>
        <div className="mt-10 flex items-center justify-center gap-x-6">
          <Link
            to="/"
            className="rounded-md bg-blue-600 px-3.5 py-2.5 text-sm font-semibold shadow-xs hover:bg-blue-500"
          >
            <h4 className="text-white">

            Go back home
            </h4>
          </Link>
        </div>
      </div>
    </main>
  );
}
