import React from 'react';

const exercises = [
  { id: 1, name: 'Abs', image: '/abs_rounded.png' },
  { id: 2, name: 'Back', image: '/back_rounded.png' },
  { id: 3, name: 'Biceps', image: '/biceps_rounded.png' },
  { id: 4, name: 'Calves', image: '/calf_rounded.png' },
  { id: 5, name: 'Chest', image: '/chest_rounded.png' },
  { id: 6, name: 'Forearm', image: '/forearm_rounded.png' },
  { id: 7, name: 'Glutes', image: '/glutes_rounded.png' },
  { id: 8, name: 'Hamstrings', image: '/harmstrings_rounded.png' },
  { id: 9, name: 'Quads', image: '/quads_rounded.png' },
  { id: 10, name: 'Neck', image: '/neck_rounded.png' },
  { id: 11, name: 'Traps', image: '/traps_rounded.png' },
  { id: 12, name: 'Triceps', image: '/triceps_rounded.png' }
];

function ExerciseCard({ name, image }) {
  const handleClick = () => {
    window.open(`http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/${getMuscleId(name)}/muscle/${name.toLowerCase()}`);
  };

  const getMuscleId = (muscleName) => {
    const muscleIds = {
      'Abs': '13',
      'Back': '4',
      'Biceps': '15',
      'Calves': '9',
      'Chest': '1',
      'Forearm': '2',
      'Glutes': '14',
      'Hamstrings': '8',
      'Quads': '7',
      'Neck': '6',
      'Traps': '11',
      'Triceps': '10'
    };
    return muscleIds[muscleName] || '1';
  };

  return (
    <div 
      onClick={handleClick}
      className="bg-white rounded-lg shadow-md p-4 flex items-center space-x-4 cursor-pointer hover:bg-gray-50 transition-colors"
    >
      <div className="w-16 h-16 rounded-full bg-gray-200 flex items-center justify-center overflow-hidden">
        <img 
          src={image} 
          alt={name} 
          className="w-full h-full object-cover"
          onError={(e) => {
            e.target.src = 'https://via.placeholder.com/64?text=' + name[0];
          }}
        />
      </div>
      <span className="text-lg font-medium text-gray-800">{name}</span>
    </div>
  );
}

function Exercises() {
  return (
    <div className="p-6">
      <h1 className="text-2xl font-semibold mb-6">Exercises</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {exercises.map((exercise) => (
          <ExerciseCard
            key={exercise.id}
            name={exercise.name}
            image={exercise.image}
          />
        ))}
      </div>
    </div>
  );
}

export default Exercises;